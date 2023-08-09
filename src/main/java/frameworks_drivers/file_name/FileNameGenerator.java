package frameworks_drivers.file_name;

/**
 * Strategy for generating a random file name
 */
public interface FileNameGenerator {
    /**
     * Generates a random file name
     * @return The generated file name
     */
    String generateFileName();
}
