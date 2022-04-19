package Client;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

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
import RiskFree.RiskFreeGrpc;
import RiskFree.Safe;
import RiskFree.positions;
import RiskFree.thanks;
import Vaccination.VaccinationGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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
			//overide the run method of runnable
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ClientGUI() {
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Client - Covid Tracker");
		frame.setBounds(100, 100, 1000, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.getContentPane().setLayout(bl);
		
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("    Cough   ");
		panel_service_1.add(lblNewLabel_1);
		textName1 = new JTextField();
		panel_service_1.add(textName1);
		textName1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("    Fever   ");
		panel_service_1.add(lblNewLabel_2);
		textName2 = new JTextField();
		panel_service_1.add(textName2);
		textName2.setColumns(10);
				
		JLabel lblNewLabel_3 = new JLabel("  Tiredness ");
		panel_service_1.add(lblNewLabel_3);	
		textName3 = new JTextField();
		panel_service_1.add(textName3);
		textName3.setColumns(10);
		
		String[] ops = new String[] {"Risk Calculator"};
		JComboBox comboOperation1 = new JComboBox();
		comboOperation1.setModel(new DefaultComboBoxModel(ops));
		panel_service_1.add(comboOperation1);
		
		JButton btnSend = new JButton("Check");
		
		btnSend.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ServiceInfo serviceInfo;
				String service_type = "_grpc._tcp.local.";
				serviceInfo = jmDNS.SimpleServiceDiscovery.run(service_type);
				String host = "localhost";
				//int port = serviceInfo.getPort();
				int port = 50051;
				
				ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
				
				CFblockingStub = CovidFreeGrpc.newBlockingStub(channel);
					
				String fever = textName1.getText();
				String cough = textName2.getText();
				String tiredness = textName3.getText();

				CovidFree.symptoms request = CovidFree.symptoms.newBuilder().setSymptom1(fever).setSymptom2(cough).setSymptom3(tiredness).build();

				CovidFree.risk response = CFblockingStub.riskCalculator(request);

				textResponse1.append("Risk: "+ response.getRiskValue() + "\n");

			}
		});//End of setup button
		
		
		panel_service_1.add(btnSend);
			
		textResponse1 = new JTextArea(3, 20);
		textResponse1.setLineWrap(true);
		textResponse1.setWrapStyleWord(true);		
		JScrollPane scrollPane = new JScrollPane(textResponse1);	
		panel_service_1.add(scrollPane);
		
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		panel_service_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel(" Position 1 ");
		panel_service_2.add(lblNewLabel_4);
		textName4 = new JTextField();
		panel_service_2.add(textName4);
		textName4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel(" Position 2 ");
		panel_service_2.add(lblNewLabel_5);
		textName5 = new JTextField();
		panel_service_2.add(textName5);
		textName5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel(" Position 3 ");
		panel_service_2.add(lblNewLabel_6);
		textName6 = new JTextField();
		panel_service_2.add(textName6);
		textName6.setColumns(10);
		
		String[] ops2 = new String[] {"Covid Positions", "Inside Safe Zones"};
		JComboBox comboOperation2 = new JComboBox();
		comboOperation2.setModel(new DefaultComboBoxModel(ops2));
		panel_service_2.add(comboOperation2);
	
		JButton btnSend2 = new JButton("Check");
		btnSend2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ServiceInfo serviceInfo;
				String service_type = "_grpc._tcp.local.";
				serviceInfo = jmDNS.SimpleServiceDiscovery.run(service_type);
				String host = "localhost";
				int port = 50052;
				
				ManagedChannel channel = ManagedChannelBuilder
						.forAddress(host, port)
						.usePlaintext()
						.build();
				
				Stub = RiskFreeGrpc.newStub(channel);
				
				int index = comboOperation2.getSelectedIndex();
				
				if(index==0) {
					
					String position1 = textName4.getText();
					String position2 = textName5.getText();
					String position3 = textName6.getText();
					
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
						
						StreamObserver<positions> requestObserver = Stub.covidPositions(responseObserver);
						
						requestObserver.onNext(positions.newBuilder().setPosition(position1).build());
						requestObserver.onNext(positions.newBuilder().setPosition(position2).build());
						requestObserver.onNext(positions.newBuilder().setPosition(position3).build());
						requestObserver.onCompleted();
	
				}
				
				if(index==1) {
					
					String position1 = textName4.getText();
					String position2 = textName5.getText();
					String position3 = textName6.getText();
					
					StreamObserver<Safe> responseObserver = new StreamObserver<Safe>() {

						@Override
						public void onNext(Safe value) {
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
							textResponse2.append( "Bi directional Streaming Completed \n");
						}
					};
						
					StreamObserver<positions> requestObserver = Stub.insideSafeZones(responseObserver);
					
					requestObserver.onNext(positions.newBuilder().setPosition(position1).build());
					requestObserver.onNext(positions.newBuilder().setPosition(position2).build());
					requestObserver.onNext(positions.newBuilder().setPosition(position3).build());
					
					requestObserver.onCompleted();
				}

			}
		}); 
		panel_service_2.add(btnSend2);
		
		
		textResponse2 = new JTextArea(3, 20);
		textResponse2 .setLineWrap(true);
		textResponse2.setWrapStyleWord(true);		
		JScrollPane scrollPane2 = new JScrollPane(textResponse2);	
		panel_service_2.add(scrollPane2);
		

		
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
		panel_service_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

		JButton btnSend3 = new JButton("Check Safe Zones");
		btnSend3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ServiceInfo serviceInfo;
				String service_type = "_grpc._tcp.local.";
				serviceInfo = jmDNS.SimpleServiceDiscovery.run(service_type);
				String host = "localhost";
				int port = 50052;
				
				ManagedChannel channel = ManagedChannelBuilder
						.forAddress(host, port)
						.usePlaintext()
						.build();
				
				RFblockingStub = RiskFreeGrpc.newBlockingStub(channel);

				RiskFree.request request = RiskFree.request.newBuilder().build();

				Iterator<RiskFree.positions> responses = RFblockingStub.safeZones(request);
				
				while (responses.hasNext()) {
					RiskFree.positions individualResponse = responses.next();
					textResponse3.append(individualResponse.getPosition() + "\n");
				}
			}
		});
		panel_service_3.add(btnSend3);

		textResponse3 = new JTextArea(3, 20);
		textResponse3.setLineWrap(true);
		textResponse3.setWrapStyleWord(true);		
		JScrollPane scrollPane3 = new JScrollPane(textResponse3);
		panel_service_3.add(scrollPane3);
		

		JLabel lblNewLabel_7 = new JLabel("      User ID ");
		panel_service_3.add(lblNewLabel_7);
		textName7 = new JTextField();
		panel_service_3.add(textName7);
		textName7.setColumns(10);
		
		String[] ops3 = new String[] {"Vaccination History", "Available Dates", "Covid History"};
		JComboBox comboOperation3 = new JComboBox();
		comboOperation3.setModel(new DefaultComboBoxModel(ops3));
		panel_service_3.add(comboOperation3);
	
		JButton btnSend4 = new JButton("Check");
		btnSend4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				int index = comboOperation3.getSelectedIndex();

				if(index==0) {
					
					ServiceInfo serviceInfo;
					String service_type = "_grpc._tcp.local.";
					serviceInfo = jmDNS.SimpleServiceDiscovery.run(service_type);
					//int port = serviceInfo.getPort();
					String host = "localhost";
					int port = 50053;
					
					ManagedChannel channel = ManagedChannelBuilder
							.forAddress(host, port)
							.usePlaintext()
							.build();
					
					VCblockingStub = VaccinationGrpc.newBlockingStub(channel);
					
					int name1 = Integer.parseInt(textName7.getText());
					
					
					Vaccination.userId request = Vaccination.userId.newBuilder().setId(name1).build();
	
					Vaccination.hadVaccination response = VCblockingStub.vaccinationHistory(request);
					
					if(response.getVaccination() == true) {
						textResponse4.append("This user got vaccination in the past \n");
					} else {
						textResponse4.append("This user did not get vaccination in the past \n");
					}

				}
				
				if(index==1) {
					
					ServiceInfo serviceInfo;
					String service_type = "_grpc._tcp.local.";
					serviceInfo = jmDNS.SimpleServiceDiscovery.run(service_type);
					//int port = serviceInfo.getPort();
					String host = "localhost";
					int port = 50053;
					
					ManagedChannel channel = ManagedChannelBuilder
							.forAddress(host, port)
							.usePlaintext()
							.build();
					
					VCblockingStub = VaccinationGrpc.newBlockingStub(channel);
					
					Vaccination.request request = Vaccination.request.newBuilder().build();
					
					Vaccination.availableDate response = VCblockingStub.seeAvailableDates(request);
					
					textResponse4.append(response.getAvailable() + "\n");
					
				}
				
				if(index==2) {
					
					ServiceInfo serviceInfo;
					String service_type = "_grpc._tcp.local.";
					serviceInfo = jmDNS.SimpleServiceDiscovery.run(service_type);
					//int port = serviceInfo.getPort();
					String host = "localhost";
					int port = 50051;
					
					ManagedChannel channel = ManagedChannelBuilder
							.forAddress(host, port)
							.usePlaintext()
							.build();
					
					int name1 = Integer.parseInt(textName7.getText());

					CovidFree.userId request = CovidFree.userId.newBuilder().setId(name1).build();
					
					CFblockingStub = CovidFreeGrpc.newBlockingStub(channel);
	
					CovidFree.hadCovid response = CFblockingStub.covidHistory(request);
					if(response.getCovid() == true) {
						textResponse4.append("This user had covid in the past \n");
					} else {
						textResponse4.append("This user did not have covid in the past \n");
					}
				}
				
			}
		});		
		panel_service_3.add(btnSend4);
			
		textResponse4 = new JTextArea(3, 20);
		textResponse4 .setLineWrap(true);
		textResponse4.setWrapStyleWord(true);		
		JScrollPane scrollPane4 = new JScrollPane(textResponse4);
		panel_service_3.add(scrollPane4);
	}
}
