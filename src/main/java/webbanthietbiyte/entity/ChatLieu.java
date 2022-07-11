package webbanvali.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat_lieu")
public class ChatLieu implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ten_chat_lieu")
	private String tenChatLieu;
	private String code;
	
	@OneToMany(mappedBy = "chatLieu")
	private List<Vali> valis;

	public ChatLieu(Integer id, String tenChatLieu, String code) {
		super();
		this.id = id;
		this.tenChatLieu = tenChatLieu;
		this.code = code;
	}

	public ChatLieu(String tenChatLieu, String code) {
		super();
		this.tenChatLieu = tenChatLieu;
		this.code = code;
	}
	
}
