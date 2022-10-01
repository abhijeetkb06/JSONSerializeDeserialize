package json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import json.objects.Employee;
import json.objects.Student;

import java.io.IOException;

public class EmployeeJsonSerializer extends JsonSerializer<Employee> {

	@Override
	public void serialize(Employee value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

		gen.writeStartObject();
		gen.writeNumberField("eId", value.geteId());
		gen.writeStringField("eName", value.geteName());
		gen.writeEndObject();
	}
}