package json.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;

import json.objects.Student;

public class StudentJsonDeSerializer extends JsonDeserializer<Student> {

	@Override
	public Student deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		JsonNode node = p.getCodec().readTree(p);
		int id = (Integer) ((IntNode) node.get("id")).numberValue();
		String name = node.get("name").asText();
		
		Student std = new Student();
		std.setId(id);
		std.setName(name);
		return std;
	}
}