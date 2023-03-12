package apasov;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public List<student> listAll(){
		return repo.findAll();
	}
	public void save(student student) {
		repo.save(student);
	}
	
	public student get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}