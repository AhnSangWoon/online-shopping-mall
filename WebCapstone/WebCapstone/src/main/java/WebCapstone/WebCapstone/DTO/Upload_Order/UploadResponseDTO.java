package WebCapstone.WebCapstone.DTO.Upload_Order;

import WebCapstone.WebCapstone.Upload.Upload;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;



import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadResponseDTO {
    private List<Upload> uploadArray;
}
