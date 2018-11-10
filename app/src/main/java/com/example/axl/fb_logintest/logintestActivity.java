package com.example.axl.fb_logintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
//import com.facebook.accountkit.AccessToken;
//
//
//import com.facebook.accountkit.LoginResult;
//import com.facebook.accountkit.ui.AccountKitActivity;
//import com.facebook.accountkit.ui.AccountKitConfiguration;
//import com.facebook.accountkit.ui.LoginType;
//
//import com.facebook.accountkit.AccountKitLoginResult;
//
//
//import com.facebook.accountkit.AccountKit;
//import com.facebook.accountkit.Account;
//import com.facebook.accountkit.PhoneNumber;
//import com.facebook.accountkit.AccountKitCallback;
//import com.facebook.accountkit.AccountKitError;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;


public class logintestActivity extends AppCompatActivity {

    CallbackManager callbackManager;
    private LoginManager loginManager;
//    AccessToken accessToken;
//            = AccountKit.getCurrentAccessToken();
//
//        if (accessToken != null) {
//        //Handle Returning User
//    } else {}
//Handle new or logged out user


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        callbackManager = CallbackManager.Factory.create();
        loginManager = LoginManager.getInstance();
        super.onCreate(savedInstanceState);

//        accessToken = AccessToken.getCurrentAccessToken();
//        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_logintest);

        LoginButton loginButton=(LoginButton)findViewById(R.id.login_button);




        loginButton.setReadPermissions("email");
        // If using in a fragment
//        loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
//                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
//
//                LoginManager.getInstance().registerCallback(callbackManager,
//                        new FacebookCallback<loginResult>() {
//                            @Override
//                            public void onSuccess(LoginResult loginResult) {
//                                // App code
//                            }
//
//                            @Override
//                            public void onCancel() {
//                                // App code
//                            }
//
//                            @Override
//                            public void onError(FacebookException exception) {
//                                // App code
//                            }
//
//
//
//                        });
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}

//    @Override
//    protected void onActivityResult(
//            final int requestCode,
//            final int resultCode,
//            final Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == APP_REQUEST_CODE) { // confirm that this response matches your request
//            AccountKitLoginResult loginResult = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
//            String toastMessage;
//            if (loginResult.getError() != null) {
//                toastMessage = loginResult.getError().getErrorType().getMessage();
//                showErrorActivity(loginResult.getError());
//            } else if (loginResult.wasCancelled()) {
//                toastMessage = "Login Cancelled";
//            } else {
//                if (loginResult.getAccessToken() != null) {
//                    toastMessage = "Success:" + loginResult.getAccessToken().getAccountId();
//                } else {
//                    toastMessage = String.format(
//                            "Success:%s...",
//                            loginResult.getAuthorizationCode().substring(0,10));
//                }
//
//                // If you have an authorization code, retrieve it from
//                // loginResult.getAuthorizationCode()
//                // and pass it to your server and exchange it for an access token.
//
//                // Success! Start your next activity...
//                goToMyLoggedInActivity();
//            }
//
//            // Surface the result to your user in an appropriate way.
//            Toast.makeText(
//                    this,
//                    toastMessage,
//                    Toast.LENGTH_LONG)
//                    .show();
//        }
//    }
//    AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
//        @Override
//        public void onSuccess(final Account account) {
//            // Get Account Kit ID
//            String accountKitId = account.getId();
//
//            // Get phone number
//            PhoneNumber phoneNumber = account.getPhoneNumber();
//            if (phoneNumber != null) {
//                String phoneNumberString = phoneNumber.toString();
//            }
//
//            // Get email
//            String email = account.getEmail();
//        }
//
//        @Override
//        public void onError(final AccountKitError error) {
//            // Handle Error
//        }
//    });
//}
//
//    public static int APP_REQUEST_CODE = 99;
//
//    public void phoneLogin(final View view) {
//        final Intent intent = new Intent(getActivity(), AccountKitActivity.class);
//        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
//                new AccountKitConfiguration.AccountKitConfigurationBuilder(
//                        LoginType.PHONE,
//                        AccountKitActivity.ResponseType.CODE); // or .ResponseType.TOKEN
//        // ... perform additional configuration ...
//        intent.putExtra(
//                AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
//                configurationBuilder.build());
//        startActivityForResult(intent, APP_REQUEST_CODE);
//    }
//
//
//import com.facebook.accountkit.AccountKit;
//        import com.facebook.accountkit.ui.AccountKitActivity;
//        import com.facebook.accountkit.ui.AccountKitConfiguration;
//        import com.facebook.accountkit.ui.LoginType;
//
//public static int APP_REQUEST_CODE = 99;
//
//public void emailLogin(final View view) {
//final Intent intent = new Intent(getActivity(), AccountKitActivity.class);
//        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
//        new AccountKitConfiguration.AccountKitConfigurationBuilder(
//        LoginType.EMAIL,
//        AccountKitActivity.ResponseType.CODE); // or .ResponseType.TOKEN
//        // ... perform additional configuration ...
//        intent.putExtra(
//        AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
//        configurationBuilder.build());
//        startActivityForResult(intent, APP_REQUEST_CODE);
//        }

