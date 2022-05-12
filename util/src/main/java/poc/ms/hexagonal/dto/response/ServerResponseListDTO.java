package poc.ms.hexagonal.dto.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServerResponseListDTO<T> {
    private List<T> data;

    public List<T> getData() {
        return this.data != null ? Collections.unmodifiableList(this.data) : Collections.emptyList();
    }

}
