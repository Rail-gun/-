package time.project;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import sun.misc.BASE64Encoder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 使用freemark生成word
 * @author stormwy
 *
 */
public class Freemark extends ActionSupport{
	public String toprint() throws Exception{  
		Freemark freemark = new Freemark("template/");
		freemark.setTemplateName("学生请假表模板.ftl");
		freemark.setFileName("doc_"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date())+".doc");
		freemark.setFilePath("bin/");
		freemark.createWord();
		return "SUCCESS";
	}  

	public void createWord(){

		Template t = null;
		try {
			t = configuration.getTemplate(templateName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		File outFile = new File(filePath+fileName);
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Map map = new HashMap<String, Object>();

		map.put("studentID", "1150320204");
		map.put("name", "王雪松");

		map.put("leavetime", "2017-11-14");
		map.put("type", "病假");
		map.put("reason", "哈哈哈，生病你管的着！！！");

		try {
			t.process(map, out);
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * freemark初始化
	 * @param templatePath 模板文件位置
	 */
	public Freemark(String templatePath) {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(this.getClass(),templatePath);
	}

	/**
	 * freemark模板配置
	 */
	private Configuration configuration;
	/**
	 * freemark模板的名字
	 */
	private String templateName;
	/**
	 * 生成文件名
	 */
	private String fileName;
	/**
	 * 生成文件路径
	 */
	private String filePath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

}
