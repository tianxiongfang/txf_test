package com.jd.email.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;

@Service
public class EmailRenderService {
	public String renderHtml(Object model, String file) throws IOException, TemplateException {
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_20);
		ClassLoader classLoader = this.getClass().getClassLoader();
		URL url = classLoader.getResource("templates");
		configuration.setDirectoryForTemplateLoading(new File(url.getFile()));
		Template template = configuration.getTemplate(file);
		StringWriter stringWriter = new StringWriter();
		template.process(model, stringWriter);
		return stringWriter.toString();
	}
}
