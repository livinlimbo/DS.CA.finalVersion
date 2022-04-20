package RiskFree;

import java.io.IOException;

import RiskFree.RiskFreeGrpc.RiskFreeImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RiskFreeServer {
public static void main(String[] args) throws IOException, InterruptedException {
		
		int port = 50052;
		String service_type = "_grpc._tcp.local.";
		String service_name = "GrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		try {
			Server server = ServerBuilder.forPort(port).addService(new RiskFreeService()).build();
			server.start();
			System.out.println("\nRisk Free Server Started");
			server.awaitTermination();
		} catch (IOException ex) {
			ex.printStackTrace();
			
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	static class RiskFreeService extends RiskFreeImplBase{

		@Override
		public StreamObserver<positions> covidPositions(StreamObserver<thanks> responseObserver) {
			
			return new StreamObserver<positions>() {
				
				@Override
				public void onNext(positions value) {
					System.out.println("On server, position received from the client :" + value.getPosition());
				}

				@Override
				public void onError(Throwable t) {
					
				}

				@Override
				public void onCompleted() {
					thanks.Builder response = thanks.newBuilder();
					response.setThank("Thanks for sharing");
					responseObserver.onNext(response.build());
					responseObserver.onCompleted();
				}
			};
		}

		@Override
		public void safeZones(request request, StreamObserver<positions> responseObserver) {
			
			positions.Builder response = positions.newBuilder();
			
			response.setPosition("Dublin 01");
			responseObserver.onNext(response.build());
			
			response.setPosition("Dublin 02");
			responseObserver.onNext(response.build());
			
			response.setPosition("Dublin 03");
			responseObserver.onNext(response.build());
			
			responseObserver.onCompleted();
		}

		@Override
		public StreamObserver<positions> insideSafeZones(StreamObserver<Safe> responseObserver) {
			
			return new StreamObserver<positions>() {

				@Override
				public void onNext(positions value) {

					System.out.println("On server, message received from the client " + value.getPosition());
					
					String position = value.getPosition();
					int positionLength = position.length();
					
					Safe.Builder response = Safe.newBuilder();
					
					if(positionLength %2 == 0) {
						response.setSafe(true);
					} else {
						response.setSafe(false);
					}
					
					responseObserver.onNext(response.build());
				}

				@Override
				public void onError(Throwable t) {
				
				}

				@Override
				public void onCompleted() {
					responseObserver.onCompleted();
				}
				
			};
		}
		
		
	}
}
