package exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exam.util.FileUtil;
import exam.util.FileUtilImpl;
import exam.util.LocalDateAdapterDeserializer;
import exam.util.LocalDateAdapterSerializer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson createGson() {

        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapterSerializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapterDeserializer())
                .create();
    }

    @Bean
    public ModelMapper createModelMapper() {

        return new ModelMapper();
    }

    @Bean
    public FileUtil createFileUtil() {

        return new FileUtilImpl();
    }
}
