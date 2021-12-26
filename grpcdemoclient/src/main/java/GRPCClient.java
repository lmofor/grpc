import com.poc.grpc.User;
import com.poc.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static com.poc.grpc.userGrpc.newBlockingStub;

public class GRPCClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost",9090)
                .usePlaintext().usePlaintext().build();

        // stubs
        userGrpc.userBlockingStub userStub =
                newBlockingStub(channel);
        User.LoginRequest loginRequest = User.LoginRequest
                .newBuilder()
                .setUsername("OMH").setPassword("OH").build();
        User.APIResponse response = userStub.login(loginRequest);

        System.out.println(response.getResponsemessage());


    }
}
