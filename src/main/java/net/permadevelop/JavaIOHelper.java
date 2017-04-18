package net.permadevelop;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Collections;

public class JavaIOHelper {
    public interface IOConsumer<T, R> {
        R accept(T t) throws IOException;
    }

    public static <R> R processResource(URI uri, IOConsumer<Path, R> action) throws IOException {
        try {
            Path p = Paths.get(uri);
            return action.accept(p);
        } catch (FileSystemNotFoundException ex) {
            try (FileSystem fs = FileSystems.newFileSystem(
                    uri, Collections.<String, Object>emptyMap())) {
                Path p = fs.provider().getPath(uri);
                return action.accept(p);
            }
        }
    }
}
