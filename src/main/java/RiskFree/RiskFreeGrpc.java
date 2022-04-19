package RiskFree;

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
    comments = "Source: RiskFreeService.proto")
public final class RiskFreeGrpc {

  private RiskFreeGrpc() {}

  public static final String SERVICE_NAME = "RiskFree";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<RiskFree.positions,
      RiskFree.thanks> getCovidPositionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "covidPositions",
      requestType = RiskFree.positions.class,
      responseType = RiskFree.thanks.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<RiskFree.positions,
      RiskFree.thanks> getCovidPositionsMethod() {
    io.grpc.MethodDescriptor<RiskFree.positions, RiskFree.thanks> getCovidPositionsMethod;
    if ((getCovidPositionsMethod = RiskFreeGrpc.getCovidPositionsMethod) == null) {
      synchronized (RiskFreeGrpc.class) {
        if ((getCovidPositionsMethod = RiskFreeGrpc.getCovidPositionsMethod) == null) {
          RiskFreeGrpc.getCovidPositionsMethod = getCovidPositionsMethod = 
              io.grpc.MethodDescriptor.<RiskFree.positions, RiskFree.thanks>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RiskFree", "covidPositions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RiskFree.positions.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RiskFree.thanks.getDefaultInstance()))
                  .setSchemaDescriptor(new RiskFreeMethodDescriptorSupplier("covidPositions"))
                  .build();
          }
        }
     }
     return getCovidPositionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RiskFree.request,
      RiskFree.positions> getSafeZonesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "safeZones",
      requestType = RiskFree.request.class,
      responseType = RiskFree.positions.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<RiskFree.request,
      RiskFree.positions> getSafeZonesMethod() {
    io.grpc.MethodDescriptor<RiskFree.request, RiskFree.positions> getSafeZonesMethod;
    if ((getSafeZonesMethod = RiskFreeGrpc.getSafeZonesMethod) == null) {
      synchronized (RiskFreeGrpc.class) {
        if ((getSafeZonesMethod = RiskFreeGrpc.getSafeZonesMethod) == null) {
          RiskFreeGrpc.getSafeZonesMethod = getSafeZonesMethod = 
              io.grpc.MethodDescriptor.<RiskFree.request, RiskFree.positions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RiskFree", "safeZones"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RiskFree.request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RiskFree.positions.getDefaultInstance()))
                  .setSchemaDescriptor(new RiskFreeMethodDescriptorSupplier("safeZones"))
                  .build();
          }
        }
     }
     return getSafeZonesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RiskFree.positions,
      RiskFree.Safe> getInsideSafeZonesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insideSafeZones",
      requestType = RiskFree.positions.class,
      responseType = RiskFree.Safe.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<RiskFree.positions,
      RiskFree.Safe> getInsideSafeZonesMethod() {
    io.grpc.MethodDescriptor<RiskFree.positions, RiskFree.Safe> getInsideSafeZonesMethod;
    if ((getInsideSafeZonesMethod = RiskFreeGrpc.getInsideSafeZonesMethod) == null) {
      synchronized (RiskFreeGrpc.class) {
        if ((getInsideSafeZonesMethod = RiskFreeGrpc.getInsideSafeZonesMethod) == null) {
          RiskFreeGrpc.getInsideSafeZonesMethod = getInsideSafeZonesMethod = 
              io.grpc.MethodDescriptor.<RiskFree.positions, RiskFree.Safe>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RiskFree", "insideSafeZones"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RiskFree.positions.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RiskFree.Safe.getDefaultInstance()))
                  .setSchemaDescriptor(new RiskFreeMethodDescriptorSupplier("insideSafeZones"))
                  .build();
          }
        }
     }
     return getInsideSafeZonesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RiskFreeStub newStub(io.grpc.Channel channel) {
    return new RiskFreeStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RiskFreeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RiskFreeBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RiskFreeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RiskFreeFutureStub(channel);
  }

  /**
   */
  public static abstract class RiskFreeImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<RiskFree.positions> covidPositions(
        io.grpc.stub.StreamObserver<RiskFree.thanks> responseObserver) {
      return asyncUnimplementedStreamingCall(getCovidPositionsMethod(), responseObserver);
    }

    /**
     */
    public void safeZones(RiskFree.request request,
        io.grpc.stub.StreamObserver<RiskFree.positions> responseObserver) {
      asyncUnimplementedUnaryCall(getSafeZonesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<RiskFree.positions> insideSafeZones(
        io.grpc.stub.StreamObserver<RiskFree.Safe> responseObserver) {
      return asyncUnimplementedStreamingCall(getInsideSafeZonesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCovidPositionsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                RiskFree.positions,
                RiskFree.thanks>(
                  this, METHODID_COVID_POSITIONS)))
          .addMethod(
            getSafeZonesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                RiskFree.request,
                RiskFree.positions>(
                  this, METHODID_SAFE_ZONES)))
          .addMethod(
            getInsideSafeZonesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                RiskFree.positions,
                RiskFree.Safe>(
                  this, METHODID_INSIDE_SAFE_ZONES)))
          .build();
    }
  }

  /**
   */
  public static final class RiskFreeStub extends io.grpc.stub.AbstractStub<RiskFreeStub> {
    private RiskFreeStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RiskFreeStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RiskFreeStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RiskFreeStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<RiskFree.positions> covidPositions(
        io.grpc.stub.StreamObserver<RiskFree.thanks> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCovidPositionsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void safeZones(RiskFree.request request,
        io.grpc.stub.StreamObserver<RiskFree.positions> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSafeZonesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<RiskFree.positions> insideSafeZones(
        io.grpc.stub.StreamObserver<RiskFree.Safe> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getInsideSafeZonesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class RiskFreeBlockingStub extends io.grpc.stub.AbstractStub<RiskFreeBlockingStub> {
    private RiskFreeBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RiskFreeBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RiskFreeBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RiskFreeBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<RiskFree.positions> safeZones(
        RiskFree.request request) {
      return blockingServerStreamingCall(
          getChannel(), getSafeZonesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RiskFreeFutureStub extends io.grpc.stub.AbstractStub<RiskFreeFutureStub> {
    private RiskFreeFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RiskFreeFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RiskFreeFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RiskFreeFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SAFE_ZONES = 0;
  private static final int METHODID_COVID_POSITIONS = 1;
  private static final int METHODID_INSIDE_SAFE_ZONES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RiskFreeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RiskFreeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAFE_ZONES:
          serviceImpl.safeZones((RiskFree.request) request,
              (io.grpc.stub.StreamObserver<RiskFree.positions>) responseObserver);
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
        case METHODID_COVID_POSITIONS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.covidPositions(
              (io.grpc.stub.StreamObserver<RiskFree.thanks>) responseObserver);
        case METHODID_INSIDE_SAFE_ZONES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.insideSafeZones(
              (io.grpc.stub.StreamObserver<RiskFree.Safe>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RiskFreeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RiskFreeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return RiskFree.RiskFreeImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RiskFree");
    }
  }

  private static final class RiskFreeFileDescriptorSupplier
      extends RiskFreeBaseDescriptorSupplier {
    RiskFreeFileDescriptorSupplier() {}
  }

  private static final class RiskFreeMethodDescriptorSupplier
      extends RiskFreeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RiskFreeMethodDescriptorSupplier(String methodName) {
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
      synchronized (RiskFreeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RiskFreeFileDescriptorSupplier())
              .addMethod(getCovidPositionsMethod())
              .addMethod(getSafeZonesMethod())
              .addMethod(getInsideSafeZonesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
