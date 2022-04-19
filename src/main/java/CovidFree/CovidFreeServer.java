package CovidFree;

import java.io.IOException;

import CovidFree.CovidFreeGrpc.CovidFreeImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CovidFreeServer {
	
	public static void main(String args []) throws IOException, InterruptedException {
		
		int port = 50051;
		String service_type = "_grpc._tcp.local.";
		String service_name = "GrpcServer";
		jmDNS.SimpleServiceRegistration ssr = new jmDNS.SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		Server server = ServerBuilder.forPort(port).addService(new CovidFreeService()).build();
		server.start();
		System.out.println("\nCovid Free Server Started");
		server.awaitTermination();
	}
	
	static class CovidFreeService extends CovidFreeImplBase{

		@Override
		public void riskCalculator(symptoms request, StreamObserver<risk> responseObserver) {
			
			String symptom1 = request.getSymptom1();
			String symptom2 = request.getSymptom2();
			String symptom3 = request.getSymptom3();
			
			risk.Builder response = risk.newBuilder();
			
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
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		}

		@Override
		public void covidHistory(userId request, StreamObserver<hadCovid> responseObserver) {

			int userTestId = request.getId();
			
			hadCovid.Builder response = hadCovid.newBuilder();
			
			if(userTestId %2 == 1) {
				response.setCovid(true);
			}
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
			
		}
		
	}
}
