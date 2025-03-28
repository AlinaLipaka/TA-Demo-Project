package helpers;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlReader {
    private final Map<String, Object> config;

    public YamlReader(String fileName) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("environments/" + fileName);
        config = yaml.load(inputStream);
    }

    public String getUrl() {return (String) config.get("url");}
    public String getName() {return (String) config.get("name");}
    public String getSurname() {return (String) config.get("surname");}
    public String getAddress() {return (String) config.get("address");}
    public String getCity() {return (String) config.get("city");}
    public String getPassword() {return (String) config.get("password");}
}
