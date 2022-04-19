package Vaccination;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: VaccinationService.proto")
public final class VaccinationGrpc {

  private VaccinationGrpc() {}

  public static final String SERVICE_NAME = "Vaccination";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Vaccination.userId,
      Vaccination.hadVaccination> getVaccinationHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "vaccinationHistory",
      requestType = Vaccination.userId.class,
      responseType = Vaccination.hadVaccination.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Vaccination.userId,
      Vaccination.hadVaccination> getVaccinationHistoryMethod() {
    io.grpc.MethodDescriptor<Vaccination.userId, Vaccination.hadVaccination> getVaccinationHistoryMethod;
    if ((getVaccinationHistoryMethod = VaccinationGrpc.getVaccinationHistoryMethod) == null) {
      synchronized (VaccinationGrpc.class) {
        if ((getVaccinationHistoryMethod = VaccinationGrpc.getVaccinationHistoryMethod) == null) {
          VaccinationGrpc.getVaccinationHistoryMethod = getVaccinationHistoryMethod = 
              io.grpc.MethodDescriptor.<Vaccination.userId, Vaccination.hadVaccination>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vaccination", "vaccinationHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Vaccination.userId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Vaccination.hadVaccination.getDefaultInstance()))
                  .setSchemaDescriptor(new VaccinationMethodDescriptorSupplier("vaccinationHistory"))
                  .build();
          }
        }
     }
     return getVaccinationHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Vaccination.request,
      Vaccination.availableDate> getSeeAvailableDatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "seeAvailableDates",
      requestType = Vaccination.request.class,
      responseType = Vaccination.availableDate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Vaccination.request,
      Vaccination.availableDate> getSeeAvailableDatesMethod() {
    io.grpc.MethodDescriptor<Vaccination.request, Vaccination.availableDate> getSeeAvailableDatesMethod;
    if ((getSeeAvailableDatesMethod = VaccinationGrpc.getSeeAvailableDatesMethod) == null) {
      synchronized (VaccinationGrpc.class) {
        if ((getSeeAvailableDatesMethod = VaccinationGrpc.getSeeAvailableDatesMethod) == null) {
          VaccinationGrpc.getSeeAvailableDatesMethod = getSeeAvailableDatesMethod = 
              io.grpc.MethodDescriptor.<Vaccination.request, Vaccination.availableDate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vaccination", "seeAvailableDates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Vaccination.request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Vaccination.availableDate.getDefaultInstance()))
                  .setSchemaDescriptor(new VaccinationMethodDescriptorSupplier("seeAvailableDates"))
                  .build();
          }
        }
     }
     return getSeeAvailableDatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VaccinationStub newStub(io.grpc.Channel channel) {
    return new VaccinationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VaccinationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VaccinationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VaccinationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VaccinationFutureStub(channel);
  }

  /**
   */
  public static abstract class VaccinationImplBase implements io.grpc.BindableService {

    /**
     */
    public void vaccinationHistory(Vaccination.userId request,
        io.grpc.stub.StreamObserver<Vaccination.hadVaccination> responseObserver) {
      asyncUnimplementedUnaryCall(getVaccinationHistoryMethod(), responseObserver);
    }

    /**
     */
    public void seeAvailableDates(Vaccination.request request,
        io.grpc.stub.StreamObserver<Vaccination.availableDate> responseObserver) {
      asyncUnimplementedUnaryCall(getSeeAvailableDatesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVaccinationHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Vaccination.userId,
                Vaccination.hadVaccination>(
                  this, METHODID_VACCINATION_HISTORY)))
          .addMethod(
            getSeeAvailableDatesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Vaccination.request,
                Vaccination.availableDate>(
                  this, METHODID_SEE_AVAILABLE_DATES)))
          .build();
    }
  }

  /**
   */
  public static final class VaccinationStub extends io.grpc.stub.AbstractStub<VaccinationStub> {
    private VaccinationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VaccinationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VaccinationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VaccinationStub(channel, callOptions);
    }

    /**
     */
    public void vaccinationHistory(Vaccination.userId request,
        io.grpc.stub.StreamObserver<Vaccination.hadVaccination> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVaccinationHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void seeAvailableDates(Vaccination.request request,
        io.grpc.stub.StreamObserver<Vaccination.availableDate> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSeeAvailableDatesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VaccinationBlockingStub extends io.grpc.stub.AbstractStub<VaccinationBlockingStub> {
    private VaccinationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VaccinationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VaccinationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VaccinationBlockingStub(channel, callOptions);
    }

    /**
     */
    public Vaccination.hadVaccination vaccinationHistory(Vaccination.userId request) {
      return blockingUnaryCall(
          getChannel(), getVaccinationHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public Vaccination.availableDate seeAvailableDates(Vaccination.request request) {
      return blockingUnaryCall(
          getChannel(), getSeeAvailableDatesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VaccinationFutureStub extends io.grpc.stub.AbstractStub<VaccinationFutureStub> {
    private VaccinationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VaccinationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VaccinationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VaccinationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Vaccination.hadVaccination> vaccinationHistory(
        Vaccination.userId request) {
      return futureUnaryCall(
          getChannel().newCall(getVaccinationHistoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Vaccination.availableDate> seeAvailableDates(
        Vaccination.request request) {
      return futureUnaryCall(
          getChannel().newCall(getSeeAvailableDatesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VACCINATION_HISTORY = 0;
  private static final int METHODID_SEE_AVAILABLE_DATES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VaccinationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VaccinationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VACCINATION_HISTORY:
          serviceImpl.vaccinationHistory((Vaccination.userId) request,
              (io.grpc.stub.StreamObserver<Vaccination.hadVaccination>) responseObserver);
          break;
        case METHODID_SEE_AVAILABLE_DATES:
          serviceImpl.seeAvailableDates((Vaccination.request) request,
              (io.grpc.stub.StreamObserver<Vaccination.availableDate>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class VaccinationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VaccinationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Vaccination.VaccinationImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Vaccination");
    }
  }

  private static final class VaccinationFileDescriptorSupplier
      extends VaccinationBaseDescriptorSupplier {
    VaccinationFileDescriptorSupplier() {}
  }

  private static final class VaccinationMethodDescriptorSupplier
      extends VaccinationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VaccinationMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (VaccinationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VaccinationFileDescriptorSupplier())
              .addMethod(getVaccinationHistoryMethod())
              .addMethod(getSeeAvailableDatesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
