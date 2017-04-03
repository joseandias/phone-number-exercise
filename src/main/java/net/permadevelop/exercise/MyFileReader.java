package net.permadevelop.exercise;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyFileReader {
    Collection<String> linesFor(String fileName) {
        URL systemResource = MyFileReader.class.getResource("/" + fileName);

        if (Objects.isNull(systemResource)) {
            throw new RuntimeException(new FileNotFoundException(MyFileReader.class.getResource("/.") + fileName));
        }
        try (Stream<String> stream = Files.lines(Paths.get(systemResource.toURI()))) {
            return stream.collect(Collectors.toList());
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
