package bg.softuni.sf06_springessentials;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;

@Component
public class Test implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        ITemplateEngine engine = createEngine();

        Context context = new Context();

        context.setVariable("name", "Ivan");

        StringWriter sw = new StringWriter();

        engine.process("test.html", context, sw);

        System.out.println(sw.toString());

    }

    private static ITemplateEngine createEngine() {

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(new ClassLoaderTemplateResolver());

        return engine;
    }
}
