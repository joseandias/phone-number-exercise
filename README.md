# phone-number-exercise

## Build, test and package
   `[project root]$ mvn package`

## Run after package
   * `[project root]$ java -jar target/phone-number-importer.jar "phone_numbers.txt"`
   * `[project root]$ java -jar target/phone-number-importer.jar "C:\phones.txt""`

## Run without tests neither package
   * `[project root]$ mvn exec:java -Dexec.args="phone_numbers.txt"`
   * `[project root]$ mvn exec:java -Dexec.args="C:\phones.txt"`
