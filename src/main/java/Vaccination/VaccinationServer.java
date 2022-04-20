package Vaccination;

import java.io.IOException;

import Vaccination.VaccinationGrpc.VaccinationImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class VaccinationServer {
public static void main(String[] args) throws IOException, InterruptedException {
		
		// service registration for jmdns
		int port = 50053;
		String service_type = "_grpc._tcp.local.";
		String service_name = "VaccinationServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		try { //creating and starting server
			Server server = ServerBuilder.forPort(port).addService(new VaccinationService()).build();
			server.start();
			System.out.println("\nVaccination Server Started");
			server.awaitTermination();
			
		} catch (IOException ex) {
			ex.printStackTrace();
			
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	// creating service class
	static class VaccinationService extends VaccinationImplBase{

		@Override // creating Vaccination History method
		public void vaccinationHistory(userId request, StreamObserver<hadVaccination> responseObserver) {
			
			// getting id value from client
			int vaccinationId = request.getId();
			
			// creating response builder to build response on server
			hadVaccination.Builder response = hadVaccination.newBuilder();
			
			// method implementation
			if(vaccinationId %2 == 0) {
				response.setVaccination(true);
			} else {
				response.setVaccination(false);
			}
			
			// building response
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
			
		}

		@Override // creating See Available Dates method
		public void seeAvailableDates(request request, StreamObserver<availableDate> responseObserver) {
			
			// creating response builder to build response on server
			availableDate.Builder response = availableDate.newBuilder();
			
			// method implementation
			String availableDates = "10/05/2022 \n" + "12/05/2022 \n" + "14/05/2022 \n" + "17/05/2022 \n" + "19/05/2022 \n";
			response.setAvailable(availableDates);
			
			// building response
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		}
		
		
	}

}
