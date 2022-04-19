package CovidFree;

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
    comments = "Source: CovidFreeService.proto")
public final class CovidFreeGrpc {

  private CovidFreeGrpc() {}

  public static final String SERVICE_NAME = "CovidFree";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CovidFree.symptoms,
      CovidFree.risk> getRiskCalculatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "risk_calculator",
      requestType = CovidFree.symptoms.class,
      responseType = CovidFree.risk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CovidFree.symptoms,
      CovidFree.risk> getRiskCalculatorMethod() {
    io.grpc.MethodDescriptor<CovidFree.symptoms, CovidFree.risk> getRiskCalculatorMethod;
    if ((getRiskCalculatorMethod = CovidFreeGrpc.getRiskCalculatorMethod) == null) {
      synchronized (CovidFreeGrpc.class) {
        if ((getRiskCalculatorMethod = CovidFreeGrpc.getRiskCalculatorMethod) == null) {
          CovidFreeGrpc.getRiskCalculatorMethod = getRiskCalculatorMethod = 
              io.grpc.MethodDescriptor.<CovidFree.symptoms, CovidFree.risk>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CovidFree", "risk_calculator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CovidFree.symptoms.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CovidFree.risk.getDefaultInstance()))
                  .setSchemaDescriptor(new CovidFreeMethodDescriptorSupplier("risk_calculator"))
                  .build();
          }
        }
     }
     return getRiskCalculatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CovidFree.userId,
      CovidFree.hadCovid> getCovidHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "covid_history",
      requestType = CovidFree.userId.class,
      responseType = CovidFree.hadCovid.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CovidFree.userId,
      CovidFree.hadCovid> getCovidHistoryMethod() {
    io.grpc.MethodDescriptor<CovidFree.userId, CovidFree.hadCovid> getCovidHistoryMethod;
    if ((getCovidHistoryMethod = CovidFreeGrpc.getCovidHistoryMethod) == null) {
      synchronized (CovidFreeGrpc.class) {
        if ((getCovidHistoryMethod = CovidFreeGrpc.getCovidHistoryMethod) == null) {
          CovidFreeGrpc.getCovidHistoryMethod = getCovidHistoryMethod = 
              io.grpc.MethodDescriptor.<CovidFree.userId, CovidFree.hadCovid>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CovidFree", "covid_history"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CovidFree.userId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CovidFree.hadCovid.getDefaultInstance()))
                  .setSchemaDescriptor(new CovidFreeMethodDescriptorSupplier("covid_history"))
                  .build();
          }
        }
     }
     return getCovidHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CovidFreeStub newStub(io.grpc.Channel channel) {
    return new CovidFreeStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CovidFreeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CovidFreeBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CovidFreeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CovidFreeFutureStub(channel);
  }

  /**
   */
  public static abstract class CovidFreeImplBase implements io.grpc.BindableService {

    /**
     */
    public void riskCalculator(CovidFree.symptoms request,
        io.grpc.stub.StreamObserver<CovidFree.risk> responseObserver) {
      asyncUnimplementedUnaryCall(getRiskCalculatorMethod(), responseObserver);
    }

    /**
     */
    public void covidHistory(CovidFree.userId request,
        io.grpc.stub.StreamObserver<CovidFree.hadCovid> responseObserver) {
      asyncUnimplementedUnaryCall(getCovidHistoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRiskCalculatorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                CovidFree.symptoms,
                CovidFree.risk>(
                  this, METHODID_RISK_CALCULATOR)))
          .addMethod(
            getCovidHistoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                CovidFree.userId,
                CovidFree.hadCovid>(
                  this, METHODID_COVID_HISTORY)))
          .build();
    }
  }

  /**
   */
  public static final class CovidFreeStub extends io.grpc.stub.AbstractStub<CovidFreeStub> {
    private CovidFreeStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CovidFreeStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CovidFreeStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CovidFreeStub(channel, callOptions);
    }

    /**
     */
    public void riskCalculator(CovidFree.symptoms request,
        io.grpc.stub.StreamObserver<CovidFree.risk> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRiskCalculatorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void covidHistory(CovidFree.userId request,
        io.grpc.stub.StreamObserver<CovidFree.hadCovid> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCovidHistoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CovidFreeBlockingStub extends io.grpc.stub.AbstractStub<CovidFreeBlockingStub> {
    private CovidFreeBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CovidFreeBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CovidFreeBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CovidFreeBlockingStub(channel, callOptions);
    }

    /**
     */
    public CovidFree.risk riskCalculator(CovidFree.symptoms request) {
      return blockingUnaryCall(
          getChannel(), getRiskCalculatorMethod(), getCallOptions(), request);
    }

    /**
     */
    public CovidFree.hadCovid covidHistory(CovidFree.userId request) {
      return blockingUnaryCall(
          getChannel(), getCovidHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CovidFreeFutureStub extends io.grpc.stub.AbstractStub<CovidFreeFutureStub> {
    private CovidFreeFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CovidFreeFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CovidFreeFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CovidFreeFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CovidFree.risk> riskCalculator(
        CovidFree.symptoms request) {
      return futureUnaryCall(
          getChannel().newCall(getRiskCalculatorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CovidFree.hadCovid> covidHistory(
        CovidFree.userId request) {
      return futureUnaryCall(
          getChannel().newCall(getCovidHistoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RISK_CALCULATOR = 0;
  private static final int METHODID_COVID_HISTORY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CovidFreeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CovidFreeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RISK_CALCULATOR:
          serviceImpl.riskCalculator((CovidFree.symptoms) request,
              (io.grpc.stub.StreamObserver<CovidFree.risk>) responseObserver);
          break;
        case METHODID_COVID_HISTORY:
          serviceImpl.covidHistory((CovidFree.userId) request,
              (io.grpc.stub.StreamObserver<CovidFree.hadCovid>) responseObserver);
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

  private static abstract class CovidFreeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CovidFreeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CovidFree.CovidFreeImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CovidFree");
    }
  }

  private static final class CovidFreeFileDescriptorSupplier
      extends CovidFreeBaseDescriptorSupplier {
    CovidFreeFileDescriptorSupplier() {}
  }

  private static final class CovidFreeMethodDescriptorSupplier
      extends CovidFreeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CovidFreeMethodDescriptorSupplier(String methodName) {
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
      synchronized (CovidFreeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CovidFreeFileDescriptorSupplier())
              .addMethod(getRiskCalculatorMethod())
              .addMethod(getCovidHistoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
