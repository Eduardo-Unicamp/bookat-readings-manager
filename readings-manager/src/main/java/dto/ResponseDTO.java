package dto;

import com.bookat.readings_manager.entity.Reading;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseDTO {
    private final List<Reading> readingsList;
    private Integer readingsCount;

    public ResponseDTO(List<Reading> readingsList){
        this.readingsList=readingsList;
        this.readingsCount = this.readingsList.size();
    }

}
