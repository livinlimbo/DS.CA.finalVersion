package Client;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import CovidFree.CovidFreeGrpc;
import CovidFree.SimpleServiceDiscovery;
import RiskFree.RiskFreeGrpc;
import RiskFree.Safe;
import RiskFree.positions;
import RiskFree.thanks;
import Vaccination.VaccinationGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ClientGUI {
	
	private static CovidFreeGrpc.CovidFreeBlockingStub CFblockingStub;
	private static RiskFreeGrpc.RiskFreeBlockingStub RFblockingStub;
	private static RiskFreeGrpc.RiskFreeStub Stub;
	private static VaccinationGrpc.VaccinationBlockingStub VCblockingStub;
	
	private JFrame frame;
	private JTextField textName1, textName2, textName3, textName4, textName5, textName6, textName7;
	private JTextArea textResponse1, textResponse2, textResponse3, textResponse4;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					// creating an instance from ClientGUI class to build GUI
					ClientGUI window = new ClientGUI();
					
					// setting visibility true
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ClientGUI() {
		
		//creating frame
		frame = new JFrame();
		frame.setTitle("Client - Covid Tracker");
		frame.setBounds(100, 100, 1000, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// setting layout to box layout
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.getContentPane().setLayout(bl);
		
		// creating panel
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// creating label and adding on the panel
		JLabel lblNewLabel_1 = new JLabel("    Cough   ");
		panel_service_1.add(lblNewLabel_1);
		textName1 = new JTextField();
		panel_service_1.add(textName1);
		textName1.setColumns(10);
		
		// creating label and adding on the panel
		JLabel lblNewLabel_2 = new JLabel("    Fever   ");
		panel_service_1.add(lblNewLabel_2);
		textName2 = new JTextField();
		panel_service_1.add(textName2);
		textName2.setColumns(10);
		
		// creating label and adding on the panel
		JLabel lblNewLabel_3 = new JLabel("  Tiredness ");
		panel_service_1.add(lblNewLabel_3);	
		textName3 = new JTextField();
		panel_service_1.add(textName3);
		textName3.setColumns(10);
		
		// creating combo box and adding on the panel
		String[] ops = new String[] {"Risk Calculator"};
		JComboBox comboOperation1 = new JComboBox();
		comboOperation1.setModel(new DefaultComboBoxModel(ops));
		panel_service_1.add(comboOperation1);
		
		//creating button and adding on the panel
		JButton btnSend = new JButton("Check");
		btnSend.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				// service discovery for jmdns
				ServiceInfo serviceInfo;
				String service_type = "_grpc._tcp.local.";
				serviceInfo = SimpleServiceDiscovery.run(service_type);
				String host = "localhost";
				//int port = serviceInfo.getPort();
				int port = 50051;
				
				// building channel
				ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
				
				// building stub
				CFblockingStub = CovidFreeGrpc.newBlockingStub(channel);
				
				try {
					
					// getting symptoms from GUI via getText method
					String fever = textName1.getText();
					String cough = textName2.getText();
					String tiredness = textName3.getText();
					
					// building request and setting responses within this request
					CovidFree.symptoms request = CovidFree.symptoms.newBuilder().setSymptom1(fever).setSymptom2(cough).setSymptom3(tiredness).build();
					
					// via creating response, implementing Risk Calculator method on server
					CovidFree.risk response = CFblockingStub.riskCalculator(request);
					
					// appending risk value in the text area on the GUI
					textResponse1.append("Risk: "+ response.getRiskValue() + "\n");
					
					// adding advice text to the text area
					if(response.getRiskValue() >= 50) {
						textResponse1.append("You better stay in your place\n");
					}
					
				// catching Status Runtime Exception
				} catch (StatusRuntimeException ex) {
					ex.printStackTrace();
				} finally {
					try {
						// at the end of the method, shutdown the channel
						channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
						
					// catching Interrupted Exception
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		// adding button on the panel
		panel_service_1.add(btnSend);
			
		// creating text area for responses to client and adding on the panel
		textResponse1 = new JTextArea(3, 20);
		textResponse1.setLineWrap(true);
		textResponse1.setWrapStyleWord(true);		
		JScrollPane scrollPane = new JScrollPane(textResponse1);	
		panel_service_1.add(scrollPane);
		
		
		// creating panel
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		panel_service_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// creating label and adding on the panel
		JLabel lblNewLabel_4 = new JLabel(" Position 1 ");
		panel_service_2.add(lblNewLabel_4);
		textName4 = new JTextField();
		panel_service_2.add(textName4);
		textName4.setColumns(10);

		// creating label and adding on the panel
		JLabel lblNewLabel_5 = new JLabel(" Position 2 ");
		panel_service_2.add(lblNewLabel_5);
		textName5 = new JTextField();
		panel_service_2.add(textName5);
		textName5.setColumns(10);

		// creating label and adding on the panel
		JLabel lblNewLabel_6 = new JLabel(" Position 3 ");
		panel_service_2.add(lblNewLabel_6);
		textName6 = new JTextField();
		panel_service_2.add(textName6);
		textName6.setColumns(10);

		// creating combo box and adding on the panel
		String[] ops2 = new String[] {"Covid Positions", "Inside Safe Zones"};
		JComboBox comboOperation2 = new JComboBox();
		comboOperation2.setModel(new DefaultComboBoxModel(ops2));
		panel_service_2.add(comboOperation2);
	
		//creating button and adding on the panel
		JButton btnSend2 = new JButton("Check");
		btnSend2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				// service discovery for jmdns
				ServiceInfo serviceInfo;
				String service_type = "_grpc._tcp.local.";
				serviceInfo = SimpleServiceDiscovery.run(service_type);
				String host = "localhost";
				int port = 50052;
				
				// building channel
				ManagedChannel channel = ManagedChannelBuilder
						.forAddress(host, port)
						.usePlaintext()
						.build();
				
				// building stub
				Stub = RiskFreeGrpc.newStub(channel);
				
				try {
					// getting index value from combo box 2
					int index = comboOperation2.getSelectedIndex();
					
					if(index==0) {
						
						// getting positions from GUI via getText method
						String position1 = textName4.getText();
						String position2 = textName5.getText();
						String position3 = textName6.getText();
						
						// creating response observer to get response information from server
						StreamObserver<thanks> responseObserver = new StreamObserver<thanks>() {
							
							@Override
							public void onNext(thanks value) {
								textResponse2.append(value.getThank() + "\n");
							}
	
							@Override
							public void onError(Throwable t) {
	
							}
	
							@Override
							public void onCompleted() {
								
							}};
							
							// creating request observer and taking position information inside it from client GUI
							StreamObserver<positions> requestObserver = Stub.covidPositions(responseObserver);
							
							requestObserver.onNext(positions.newBuilder().setPosition(position1).build());
							requestObserver.onNext(positions.newBuilder().setPosition(position2).build());
							requestObserver.onNext(positions.newBuilder().setPosition(position3).build());
							
							requestObserver.onCompleted();
		
					}
					
					if(index==1) {
						
						// getting positions from GUI via getText method
						String position1 = textName4.getText();
						String position2 = textName5.getText();
						String position3 = textName6.getText();
						
						// creating response observer to get response information from server
						StreamObserver<Safe> responseObserver = new StreamObserver<Safe>() {
	
							@Override
							public void onNext(Safe value) {
								
								//for each value that coming from client GUI, adding response accordingly
								if(value.getSafe()==true) {
									textResponse2.append("Position safe\n");	
								} else {
									textResponse2.append("Position not safe\n");	
								}
							}
	
							@Override
							public void onError(Throwable t) {
								
							}
	
							@Override
							public void onCompleted() {
								
							}
						};
						
						// creating request observer and taking position information inside it from client GUI
						StreamObserver<positions> requestObserver = Stub.insideSafeZones(responseObserver);
						
						requestObserver.onNext(positions.newBuilder().setPosition(position1).build());
						requestObserver.onNext(positions.newBuilder().setPosition(position2).build());
						requestObserver.onNext(positions.newBuilder().setPosition(position3).build());
						
						requestObserver.onCompleted();
					}
					
				// catching Status Runtime Exception
				} catch (StatusRuntimeException ex) {
					ex.printStackTrace();
				}
			}
		}); 
		panel_service_2.add(btnSend2);
		
		// creating text area for responses to client and adding on the panel
		textResponse2 = new JTextArea(3, 20);
		textResponse2 .setLineWrap(true);
		textResponse2.setWrapStyleWord(true);		
		JScrollPane scrollPane2 = new JScrollPane(textResponse2);	
		panel_service_2.add(scrollPane2);
		

		// creating panel
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
		panel_service_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

		//creating button and adding on the panel
		JButton btnSend3 = new JButton("Check Dangerous Zones");
		btnSend3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				// service discovery for jmdns
				ServiceInfo serviceInfo;
				String service_type = "_grpc._tcp.local.";
				serviceInfo = SimpleServiceDiscovery.run(service_type);
				String host = "localhost";
				int port = 50052;
				
				// building channel
				ManagedChannel channel = ManagedChannelBuilder
						.forAddress(host, port)
						.usePlaintext()
						.build();
				
				// building stub
				RFblockingStub = RiskFreeGrpc.newBlockingStub(channel);
				
				try {
					
					// building request
					RiskFree.request request = RiskFree.request.newBuilder().build();
					
					// building multiple responses with using iterator
					Iterator<RiskFree.positions> responses = RFblockingStub.safeZones(request);
					
					// iterating responses with hasNext method
					while (responses.hasNext()) {
						
						// getting position value from server and appending them in the text area on the GUI
						RiskFree.positions individualResponse = responses.next();
						//if(individualResponse.getPosition().length() % 2 == 0) {
							textResponse3.append(individualResponse.getPosition() + "\n");
						//} else {
							//textResponse3.append(individualResponse.getPosition() + " is not safe\n");
						//}
					}
					
				// catching Status Runtime Exception
				} catch (StatusRuntimeException ex)  {
					ex.printStackTrace();
				}
			}
		});
		panel_service_3.add(btnSend3);
		
		// creating text area for responses to client and adding on the panel
		textResponse3 = new JTextArea(3, 20);
		textResponse3.setLineWrap(true);
		textResponse3.setWrapStyleWord(true);		
		JScrollPane scrollPane3 = new JScrollPane(textResponse3);
		panel_service_3.add(scrollPane3);
		

		// creating label and adding on the panel
		JLabel lblNewLabel_7 = new JLabel("      User ID ");
		panel_service_3.add(lblNewLabel_7);
		textName7 = new JTextField();
		panel_service_3.add(textName7);
		textName7.setColumns(10);

		// creating combo box and adding on the panel
		String[] ops3 = new String[] {"Vaccination History", "Available Dates", "Covid History"};
		JComboBox comboOperation3 = new JComboBox();
		comboOperation3.setModel(new DefaultComboBoxModel(ops3));
		panel_service_3.add(comboOperation3);

		//creating button and adding on the panel
		JButton btnSend4 = new JButton("Check");
		btnSend4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				// getting index value from combo box 3
				int index = comboOperation3.getSelectedIndex();

				if(index==0) {
					
					// service discovery for jmdns
					ServiceInfo serviceInfo;
					String service_type = "_grpc._tcp.local.";
					serviceInfo = SimpleServiceDiscovery.run(service_type);
					//int port = serviceInfo.getPort();
					String host = "localhost";
					int port = 50053;
					
					// building channel
					ManagedChannel channel = ManagedChannelBuilder
							.forAddress(host, port)
							.usePlaintext()
							.build();
					
					// building stub
					VCblockingStub = VaccinationGrpc.newBlockingStub(channel);
					
					try {
						// getting user id from GUI via getText method
						int userID = Integer.parseInt(textName7.getText());
						
						// building request and setting user id with in this request
						Vaccination.userId request = Vaccination.userId.newBuilder().setId(userID).build();
						
						// via creating response, implementing Vaccination History method on server
						Vaccination.hadVaccination response = VCblockingStub.vaccinationHistory(request);
						
						// appending Vaccination information in the text area on the GUI
						if(response.getVaccination() == true) {
							textResponse4.append("This user got vaccination in the past \n");
						} else {
							textResponse4.append("This user did not get vaccination in the past \n");
						}
					} catch (StatusRuntimeException ex) {
						ex.printStackTrace();
					}
				}
				
				if(index==1) {
					
					// service discovery for jmdns
					ServiceInfo serviceInfo;
					String service_type = "_grpc._tcp.local.";
					serviceInfo = SimpleServiceDiscovery.run(service_type);
					//int port = serviceInfo.getPort();
					String host = "localhost";
					int port = 50053;
					
					// building channel
					ManagedChannel channel = ManagedChannelBuilder
							.forAddress(host, port)
							.usePlaintext()
							.build();
					
					// building stub
					VCblockingStub = VaccinationGrpc.newBlockingStub(channel);
					
					try {
						// building request
						Vaccination.request request = Vaccination.request.newBuilder().build();
						
						// via creating response, implementing See Available Dates method on server
						Vaccination.availableDate response = VCblockingStub.seeAvailableDates(request);
						
						// appending available date information in the text area on the GUI
						textResponse4.append(response.getAvailable() + "\n");
						
					// catching Status Runtime Exception
					} catch (StatusRuntimeException ex) {
						ex.printStackTrace();
					}					
				}
				
				if(index==2) {
					
					// service discovery for jmdns
					ServiceInfo serviceInfo;
					String service_type = "_grpc._tcp.local.";
					serviceInfo = SimpleServiceDiscovery.run(service_type);
					//int port = serviceInfo.getPort();
					String host = "localhost";
					int port = 50051;
					
					// building channel
					ManagedChannel channel = ManagedChannelBuilder
							.forAddress(host, port)
							.usePlaintext()
							.build();
					
					// building stub
					CFblockingStub = CovidFreeGrpc.newBlockingStub(channel);
					
					try {
						
						// getting user id from GUI via getText method
						int userID = Integer.parseInt(textName7.getText());
						
						// building request and setting user id with in this request
						CovidFree.userId request = CovidFree.userId.newBuilder().setId(userID).build();
						
						// via creating response, implementing Covid History method on server
						CovidFree.hadCovid response = CFblockingStub.covidHistory(request);
						
						// appending past Covid information in the text area on the GUI
						if(response.getCovid() == true) {
							textResponse4.append("This user had covid in the past \n");
						} else {
							textResponse4.append("This user did not have covid in the past \n");
						}
						
					// catching Status Runtime Exception
					} catch (StatusRuntimeException ex) {
						ex.printStackTrace();
					}
				}
				
			}
		});		
		panel_service_3.add(btnSend4);
		
		// creating text area for responses to client and adding on the panel
		textResponse4 = new JTextArea(3, 20);
		textResponse4 .setLineWrap(true);
		textResponse4.setWrapStyleWord(true);		
		JScrollPane scrollPane4 = new JScrollPane(textResponse4);
		panel_service_3.add(scrollPane4);
	}	
}
