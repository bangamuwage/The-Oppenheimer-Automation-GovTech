package APIResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import test.base.BaseResponseDTO;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class TaxReliefResponseDTO extends BaseResponseDTO{

	private String natid;
	private String name;
	private String relief;
	 
}
