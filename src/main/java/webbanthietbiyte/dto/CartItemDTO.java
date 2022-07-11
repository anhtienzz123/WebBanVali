package webbanvali.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItemDTO {

	private String slug;
	private String kichThuocCode;
	private String mauSacCode;
	private Integer soLuong;

	public CartItemDTO(String slug, String kichThuocCode, String mauSacCode) {
		super();
		this.slug = slug;
		this.kichThuocCode = kichThuocCode;
		this.mauSacCode = mauSacCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kichThuocCode == null) ? 0 : kichThuocCode.hashCode());
		result = prime * result + ((mauSacCode == null) ? 0 : mauSacCode.hashCode());
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemDTO other = (CartItemDTO) obj;
		if (kichThuocCode == null) {
			if (other.kichThuocCode != null)
				return false;
		} else if (!kichThuocCode.equals(other.kichThuocCode))
			return false;
		if (mauSacCode == null) {
			if (other.mauSacCode != null)
				return false;
		} else if (!mauSacCode.equals(other.mauSacCode))
			return false;
		if (slug == null) {
			if (other.slug != null)
				return false;
		} else if (!slug.equals(other.slug))
			return false;
		return true;
	}

}
