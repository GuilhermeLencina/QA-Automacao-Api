package Utils;

public class Endpoints {

    protected static final String BASE_URI = FileOperation.getProperties("Environment").getProperty("baseUri");
    protected static final String BASE_PATH = FileOperation.getProperties("Environment").getProperty("basePath");

}
