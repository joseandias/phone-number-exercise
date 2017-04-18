package net.permadevelop.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.permadevelop.JavaIOHelper.processResource;

class MyFileReader {
    Collection<String> linesFor(String fileName) {
        Optional<URI> fileUri = findFromClassPath(fileName);

        if (!fileUri.isPresent()) {
            fileUri = findFromAbsolutePath(fileName);
        }

        return fileUri.map(this::readLines).orElseThrow(
                () -> new RuntimeException(new FileNotFoundException(fileName))
        );
    }

    private Collection<String> readLines(URI uri) {
        try {
            return processResource(uri, path -> {
                try (Stream<String> stream = Files.lines(path)) {
                    return stream.collect(Collectors.toList());
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Optional<URI> findFromAbsolutePath(String fileName) {
        File file = new File(fileName);
        return file.exists() ? Optional.of(file.toURI()) : Optional.empty();
    }

    private Optional<URI> findFromClassPath(String fileName) {
        URL systemResource = MyFileReader.class.getClassLoader().getResource(fileName);
        try {
            return Objects.isNull(systemResource) ? Optional.empty() : Optional.of(systemResource.toURI());
        } catch (URISyntaxException e) {
            return Optional.empty();
        }
    }

}
