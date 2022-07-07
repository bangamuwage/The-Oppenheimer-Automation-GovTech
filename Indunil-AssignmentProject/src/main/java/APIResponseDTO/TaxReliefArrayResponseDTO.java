package APIResponseDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import test.base.BaseResponseDTO;
import test.base.TestBase;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TaxReliefArrayResponseDTO  extends BaseResponseDTO{

	 private List<TaxReliefResponseDTO> taxRelief;
}
