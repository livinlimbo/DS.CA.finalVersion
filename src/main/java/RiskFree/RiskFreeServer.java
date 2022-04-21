package RiskFree;

import java.io.IOException;

import RiskFree.RiskFreeGrpc.RiskFreeImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RiskFreeServer {
public static void main(String[] args) throws IOException, InterruptedException {
		
		// service registration for jmdns
		int port = 50052;
		String service_type = "_grpc._tcp.local.";
		String service_name = "RiskFreeServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		try { //creating and starting server
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
	
	//creating service class
	static class RiskFreeService extends RiskFreeImplBase{
		
		String [] dangerousPositions = new String[3];
		int counter = 0;
		
		@Override // creating Covid Position method
		public StreamObserver<positions> covidPositions(StreamObserver<thanks> responseObserver) {
			
			// creating Stream Observer
			return new StreamObserver<positions>() {
				
				@Override
				public void onNext(positions value) { // getting position value from client via getPosition method
					System.out.println("On server, position received from the client :" + value.getPosition());
					dangerousPositions[counter] = value.getPosition();
					counter++;
				}

				@Override
				public void onError(Throwable t) {
					
				}

				@Override
				public void onCompleted() {
					
					// creating response builder to build response on server
					thanks.Builder response = thanks.newBuilder();
					response.setThank("Thanks for sharing");
					
					// building response
					responseObserver.onNext(response.build());
					
					responseObserver.onCompleted();
				}
			};
		}

		@Override // creating Safe Zones method
		public void safeZones(request request, StreamObserver<positions> responseObserver) {
			
			// creating response builder to build response on server
			positions.Builder response = positions.newBuilder();
			
			// method implementation
			response.setPosition(dangerousPositions[0]);
			responseObserver.onNext(response.build());
			
			//setting position via setPosition method
			response.setPosition(dangerousPositions[1]);
			responseObserver.onNext(response.build());
			
			//setting position via setPosition method
			response.setPosition(dangerousPositions[2]);
			responseObserver.onNext(response.build());
			
			// building response
			responseObserver.onCompleted();
		}

		@Override // creating Inside Safe Zones method
		public StreamObserver<positions> insideSafeZones(StreamObserver<Safe> responseObserver) {
			
			// creating Stream Observer
			return new StreamObserver<positions>() {

				@Override
				public void onNext(positions value) {
					
					// getting position value from client via getPosition method
					System.out.println("On server, message received from the client " + value.getPosition());
					
					// creating response builder to build response on server
					Safe.Builder response = Safe.newBuilder();
					
					// method implementation
					String position = value.getPosition();
						
					if(position.equalsIgnoreCase(dangerousPositions[0]) || position.equalsIgnoreCase(dangerousPositions[1]) || position.equalsIgnoreCase(dangerousPositions[2]) ){
						response.setSafe(false);
					} else {
						response.setSafe(true);
					}
					
					// building response
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
