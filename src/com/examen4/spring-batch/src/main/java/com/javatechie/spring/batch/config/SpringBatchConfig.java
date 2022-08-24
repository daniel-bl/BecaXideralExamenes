/*	Becerril Becerril Daniel
 * 	Proyecto Spring Batch
 * 	23/08/2022
 * 	Métodos para la ejecución de los trabajos
 * */
package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Empleado;
import com.javatechie.spring.batch.repository.EmpleadoRepository;
import lombok.AllArgsConstructor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private EmpleadoRepository empleadoRepository;
    //Lector del archivo csv
	@Bean
    public FlatFileItemReader<Empleado> reader() {
        FlatFileItemReader<Empleado> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/empleados.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }
	//Regresa una lista de empleados
    private LineMapper<Empleado> lineMapper() {
        DefaultLineMapper<Empleado> lineMapper = new DefaultLineMapper<>();
        //Establece las columnas
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

        BeanWrapperFieldSetMapper<Empleado> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Empleado.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }
    //Ejecuta el proceso de empleado
    @Bean
    public EmpleadoProcessor processor() {
        return new EmpleadoProcessor();
    }
    //Guarda los datos
    @Bean
    public RepositoryItemWriter<Empleado> writer() {
        RepositoryItemWriter<Empleado> writer = new RepositoryItemWriter<>();
        writer.setRepository(empleadoRepository);
        writer.setMethodName("save");
        return writer;
    }
    //Paso 1, ejecuta todas las tareas del proceso
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("csv-step").<Empleado, Empleado>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }
    //Define los trabajos
    @Bean
    public Job runJob() {
        return jobBuilderFactory.get("importEmpleados")
                .flow(step1()).end().build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

}
