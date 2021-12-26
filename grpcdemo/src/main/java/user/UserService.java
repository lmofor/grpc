package user;

import com.poc.grpc.User;
import com.poc.grpc.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase {

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {

        System.out.println("Inside login");

        String username = request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if (username.equals(password)){
            response.setResponsecode(0).setResponsemessage("SUCCESS");
        }else {
            response.setResponsecode(100).setResponsemessage("INVALID PASSWORD");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        super.logout(request, responseObserver);
    }
}
