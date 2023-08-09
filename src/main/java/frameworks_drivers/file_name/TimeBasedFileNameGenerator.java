package frameworks_drivers.file_name;

public class TimeBasedFileNameGenerator implements FileNameGenerator {
    @Override
    public String generateFileName() {
        return "drawing-" + System.currentTimeMillis() + ".png";
    }
}
