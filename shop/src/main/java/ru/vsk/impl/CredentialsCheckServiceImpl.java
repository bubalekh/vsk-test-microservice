package ru.vsk.impl;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vsk.auth.AuthStorage;
import ru.vsk.grpc.CheckCredentialsRequest;
import ru.vsk.grpc.CheckCredentialsResponse;
import ru.vsk.grpc.CheckCredentialsServiceGrpc;

@GrpcService
public class CredentialsCheckServiceImpl extends CheckCredentialsServiceGrpc.CheckCredentialsServiceImplBase {

    @Autowired
    private AuthStorage authStorage;
    @Override
    public void checkCredentials(CheckCredentialsRequest request, StreamObserver<CheckCredentialsResponse> responseObserver) {
        CheckCredentialsResponse response = CheckCredentialsResponse.newBuilder()
                .setValid(authStorage.isValidCredentials(request.getPhone(), request.getPassword()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
