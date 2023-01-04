package com.example.apitesteur.batch;

import com.example.apitesteur.Personne;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class SpringBatchConfiguration {

    @Autowired
    private PersonneWriter personneWriter;

    @Bean
    public FlatFileItemReader<Personne> reader() {
        return new FlatFileItemReaderBuilder<Personne>()
                .name("personItemReader")
                .resource(new ClassPathResource("data.csv"))
                .delimited()
                .names(new String[]{"nom", "prenom"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Personne>() {{
                    setTargetType(Personne.class);
                }})
                .build();
    }


    @Bean
    public Processor processor() {
        return new Processor();
    }


    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory
    ) {

        Step step = stepBuilderFactory.get("ETL-file-load")
                .<Personne, Personne>chunk(1000)
                .reader(reader())
                .processor(processor())
                .writer(personneWriter)
                .build();


        return jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }


}
