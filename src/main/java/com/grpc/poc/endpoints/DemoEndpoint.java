package com.grpc.poc.endpoints;

import com.grpc.poc.PocGrpcReply;
import com.grpc.poc.PocGrpcRequest;
import com.grpc.poc.PocGrpcServiceGrpc;
import com.grpc.poc.usecase.PrintName;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class DemoEndpoint extends PocGrpcServiceGrpc.PocGrpcServiceImplBase {

    private final PrintName printName;

    public DemoEndpoint(PrintName printName) {
        this.printName = printName;
    }

    @Override
    public void send(PocGrpcRequest request, StreamObserver<PocGrpcReply> responseObserver) {
        printName.execute(request.getName());
        responseObserver.onNext(PocGrpcReply.newBuilder().setMessage("world").build());
        responseObserver.onCompleted();
    }
}
