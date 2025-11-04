package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Exceptions;

import lombok.Getter;

public class ExceptionColumnDuplicate extends RuntimeException {
    @Getter
    private String columnDuplicate;

    public ExceptionColumnDuplicate(String message) {
        super(message);
    }

    public ExceptionColumnDuplicate(String message, String columnDuplicate){
        super(message);
        this.columnDuplicate = columnDuplicate;
    }
}
