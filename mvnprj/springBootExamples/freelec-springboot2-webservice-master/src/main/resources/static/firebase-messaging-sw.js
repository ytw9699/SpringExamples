importScripts('https://www.gstatic.com/firebasejs/9.9.3/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/9.9.3/firebase-messaging.js');

// Initialize the Firebase app in the service worker by passing in
// your app's Firebase config object.
// https://firebase.google.com/docs/web/setup#config-object
firebase.initializeApp({
    apiKey: "AIzaSyCT7VLIEE4U1RIU5iTzunh0DLaMua4fihY",
    authDomain: "applebit-60a8b.firebaseapp.com",
    projectId: "applebit-60a8b",
    storageBucket: "applebit-60a8b.appspot.com",
    messagingSenderId: "649006992256",
    appId: "1:649006992256:web:0a6dd9c2b0b91ec6554f65",
    measurementId: "G-M1742PQN6N"
});

// Retrieve an instance of Firebase Messaging so that it can handle background
// messages.
