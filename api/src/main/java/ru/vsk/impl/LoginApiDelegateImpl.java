package ru.vsk.impl;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.vsk.api.LoginApiDelegate;
import ru.vsk.grpc.CheckCredentialsRequest;
import ru.vsk.grpc.CheckCredentialsServiceGrpc;
import ru.vsk.model.CredentialsRequest;
import ru.vsk.model.CredentialsResponse;

@Service
public class LoginApiDelegateImpl implements LoginApiDelegate {

    @GrpcClient("grpc-credentials-service")
    CheckCredentialsServiceGrpc.CheckCredentialsServiceBlockingStub stub;

    @Override
    public ResponseEntity<CredentialsResponse> userLogin(CredentialsRequest credentials) {
        CheckCredentialsRequest request = CheckCredentialsRequest.newBuilder()
                .setPhone(credentials.getPhone())
                .setPassword(credentials.getPassword())
                .build();
        CredentialsResponse response = new CredentialsResponse()
                .valid(stub.checkCredentials(request).getValid());
        return ResponseEntity.ok(response);
    }
}
