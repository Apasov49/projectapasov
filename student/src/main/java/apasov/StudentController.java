package apasov;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public List<student> list() {
		return service.listAll();
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<student> get(@PathVariable Integer id) {
		try {
			student student = service.get(id);
		return new ResponseEntity<student>(student,HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<student>(HttpStatus.NOT_FOUND);
		}
		
	}
	@PostMapping("/students")
	public void add(@RequestBody student student) {
		service.save(student);
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<?> update(@RequestBody student student,
			@PathVariable Integer id) {
		try {
			student existStudent = service.get(id);
			service.save(student);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/students{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}