package json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import json.objects.Employee;

import java.io.IOException;

public class EmployeeJsonDeSerializer extends JsonDeserializer<Employee> {

	@Override
	public Employee deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		JsonNode node = p.getCodec().readTree(p);
		int eId = (Integer) ((IntNode) node.get("eId")).numberValue();
		String eName = node.get("eName").asText();

		Employee std = new Employee();
		std.seteId(eId);
		std.seteName(eName);
		return std;
	}
}