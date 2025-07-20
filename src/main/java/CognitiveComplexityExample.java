import java.util.List;

public class CognitiveComplexityExample {
    public void before() {
        List<SomeDTO> dtos = getDTOs();
        dtos.stream().filter(dto -> dto.getValue() != null && !dto.getValue().isEmpty())
                .forEach(dto -> {
                    if (dto.getValue().length() > 5) {
                        System.out.println("Long value: " + dto.getValue());
                    } else {
                        System.out.println("Short value: " + dto.getValue());
                    }
                    if (dto.getValue().contains("value")) {
                        System.out.println("Contains 'value': " + dto.getValue());
                    } else {
                        System.out.println("Does not contain 'value': " + dto.getValue());
                    }
                    if (dto.getValue().startsWith("v")) {
                        System.out.println("Starts with 'v': " + dto.getValue());
                    } else {
                        System.out.println("Does not start with 'v': " + dto.getValue());
                    }
                    if (dto.getValue().endsWith("1")) {
                        System.out.println("Ends with '1': " + dto.getValue());
                    } else {
                        System.out.println("Does not end with '1': " + dto.getValue());
                    }
                    if (dto.getValue().length() > 10) {
                        System.out.println("Very long value: " + dto.getValue());
                    } else {
                        System.out.println("Not very long value: " + dto.getValue());
                    }
                });
    }

    public void after() {
        List<SomeDTO> dtos = getDTOs(); // Split code into multiple methods
        dtos.stream()
                .filter(this::isValueValid)
                .forEach(this::processValue);
    }

    public boolean isValueValid(SomeDTO dto) {
        return dto.getValue() != null && !dto.getValue().isEmpty();
    }

    public void processValue(SomeDTO dto) {
        checkValueLength(dto); // Split logic into smaller pieces
        checkValueContents(dto);
    }

    public void checkValueContents(SomeDTO dto) {
        String value = dto.getValue();
        if (value.contains("value")) {
            System.out.println("Contains 'value': " + value);
        } else {
            System.out.println("Does not contain 'value': " + value);
        }
        if (value.startsWith("v")) {
            System.out.println("Starts with 'v': " + value);
        } else {
            System.out.println("Does not start with 'v': " + value);
        }
        if (value.endsWith("1")) {
            System.out.println("Ends with '1': " + value);
        } else {
            System.out.println("Does not end with '1': " + value);
        }
    }

    public void checkValueLength(SomeDTO dto) {
        String value = dto.getValue();
        if (value.length() > 5) {
            System.out.println("Long value: " + value);
        } else {
            System.out.println("Short value: " + value);
        }
        if (value.length() > 10) {
            System.out.println("Very long value: " + value);
        } else {
            System.out.println("Not very long value: " + value);
        }
    }

    private List<SomeDTO> getDTOs() {
        return List.of(
                new SomeDTO("value1"),
                new SomeDTO("value2"),
                new SomeDTO("value3")
        );
    }


    public class SomeDTO {
        private String value;

        public SomeDTO(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
