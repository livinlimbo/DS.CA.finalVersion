package CovidFree;

import java.io.IOException;

import CovidFree.CovidFreeGrpc.CovidFreeImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CovidFreeServer {
	
	public static void main(String args []) throws IOException, InterruptedException {
		
		// service registration for jmdns
		int port = 50051;
		String service_type = "_grpc._tcp.local.";
		String service_name = "CovidFreeServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		try { //creating and starting server
			Server server = ServerBuilder.forPort(port).addService(new CovidFreeService()).build();
			server.start();
			System.out.println("\nCovid Free Server Started");
			server.awaitTermination();
			
		} catch (IOException ex) {
			ex.printStackTrace();
			
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	// creating service class
	static class CovidFreeService extends CovidFreeImplBase{

		@Override // creating Risk Calculator method
		public void riskCalculator(symptoms request, StreamObserver<risk> responseObserver) {
			
			// getting symptoms from client via getSymptom methods
			String symptom1 = request.getSymptom1();
			String symptom2 = request.getSymptom2();
			String symptom3 = request.getSymptom3();
			
			// creating response builder to build response on server
			risk.Builder response = risk.newBuilder();
			
			// method implementation
			int s1 = 0;
			int s2 = 0;
			int s3 = 0;
			
			if(symptom1.equalsIgnoreCase("yes")) {
				s1 = 1;
			}
			if(symptom2.equalsIgnoreCase("yes")) {
				s2 = 1;
			}
			if(symptom3.equalsIgnoreCase("yes")) {
				s3 = 1;
			}
			
			int sTotal = s1 + s2 + s3;
			
			if(sTotal == 0) {
				response.setRiskValue(0);
			}
			else if(sTotal == 1) {
				response.setRiskValue(30);
			}
			else if(sTotal == 2) {
				response.setRiskValue(60);
			}
			else if(sTotal == 3) {
				response.setRiskValue(90);
			} else {}
			
			// building response
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		}

		@Override // creating Covid History method
		public void covidHistory(userId request, StreamObserver<hadCovid> responseObserver) {
			
			// getting user id from client via getId method
			int userTestId = request.getId();
			
			// creating response builder to build response on server
			hadCovid.Builder response = hadCovid.newBuilder();
			
			// method implementation
			if(userTestId %2 == 1) {
				response.setCovid(true);
			}
			
			// building response
			responseObserver.onNext(response.build());
			
			responseObserver.onCompleted();
		}
		
	}
}
