package json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.javafaker.Faker;

import json.deserializer.EmployeeJsonDeSerializer;
import json.deserializer.StudentJsonDeSerializer;
import json.objects.Employee;
import json.objects.Student;
import json.serializer.EmployeeJsonSerializer;
import json.serializer.StudentJsonSerializer;

//https://dzone.com/articles/custom-json-deserialization-with-jackson
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class LaunchSerializerDeserializer {
	
	public static void main(String args[]) throws Exception {
		
//		Student std = new Student(500, Set.of("Physics", "Chemistry", "Mathematics"), List.of(84, 65, 90),
//				new String[] { "B", "C", "A" });
		
		// Creating the ObjectMapper object
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

//		std.setId(001);
//		std.setName("Krishna");

		Faker studentFaker = new Faker();
		Student std = new Student();
		std.setId(studentFaker.idNumber().hashCode());
		std.setName(studentFaker.name().fullName());

		/*
		 * String streetName = faker.address().streetName(); String number =
		 * faker.address().buildingNumber(); String city = faker.address().city();
		 * String country = faker.address().country();
		 * 
		 * System.out.println(String.format("%s\n%s\n%s\n%s", number, streetName, city,
		 * country));
		 */
		
		SimpleModule studentModule = new SimpleModule();
		studentModule.addSerializer(Student.class, new StudentJsonSerializer());
		mapper.registerModule(studentModule);
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);

		// Converting the Object to JSONString
		String jsonString = mapper.writeValueAsString(std);
		System.out.println(jsonString);
		
		// Converting the JSONString to Object
	    studentModule.addDeserializer(Student.class, new StudentJsonDeSerializer());
	    mapper.registerModule(studentModule);
		Student student = mapper.readValue(jsonString, Student.class);
		System.out.println("Student ID: "+ student.getId());
		System.out.println("Student Name: "+ student.getName());

		// Employee object serialization and deserialization
		Faker empFaker = new Faker();
		Employee emp = new Employee();
		emp.seteId(empFaker.idNumber().hashCode());
		emp.seteName(empFaker.name().fullName());

		SimpleModule empModule = new SimpleModule();
		empModule.addSerializer(Employee.class, new EmployeeJsonSerializer());
		mapper.registerModule(empModule);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		// Converting the Object to JSONString
		String empJsonString = mapper.writeValueAsString(emp);
		System.out.println(empJsonString);

		// Converting the JSONString to Object
		empModule.addDeserializer(Employee.class, new EmployeeJsonDeSerializer());
		mapper.registerModule(empModule);
		Employee employee = mapper.readValue(empJsonString, Employee.class);
		System.out.println("Employee ID: "+ employee.geteId());
		System.out.println("Employee Name: "+ employee.geteName());
	}
}