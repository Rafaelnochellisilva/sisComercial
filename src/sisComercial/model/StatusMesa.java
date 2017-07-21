package sisComercial.model;

import java.util.ArrayList;
import java.util.List;

public class StatusMesa {

	public static List<Status> retornaStatusMesa() {
		List<Status> status = new ArrayList<>();
		try {
			Status ocupada = new Status();
			ocupada.setStatus("ocupada");
			Status livre = new Status();
			livre.setStatus("livre");
			status.add(ocupada);
			status.add(livre);
		} catch (Exception e) {
			System.err.println("Não foi possivel retornar o status" + e.getMessage());
		}

		return status;

	}

	
	

}
