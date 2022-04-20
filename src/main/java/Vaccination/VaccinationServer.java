package Vaccination;

import java.io.IOException;

import Vaccination.VaccinationGrpc.VaccinationImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class VaccinationServer {
public static void main(String[] args) throws IOException, InterruptedException {
		
		int port = 50053;
		String service_type = "_grpc._tcp.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		try {
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
	
	static class VaccinationService extends VaccinationImplBase{

		@Override
		public void vaccinationHistory(userId request, StreamObserver<hadVaccination> responseObserver) {
			
			int vaccinationId = request.getId();
			
			hadVaccination.Builder response = hadVaccination.newBuilder();
			
			if(vaccinationId %2 == 0) {
				response.setVaccination(true);
			} else {
				response.setVaccination(false);
			}
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
			
		}

		@Override
		public void seeAvailableDates(request request, StreamObserver<availableDate> responseObserver) {
			availableDate.Builder response = availableDate.newBuilder();
			String availableDates = "10/05/2022 \n" + "12/05/2022 \n" + "14/05/2022 \n" + "17/05/2022 \n" + "19/05/2022 \n";
			response.setAvailable(availableDates);
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		}
		
		
	}

}
