
import React from 'react'
import { StyleSheet, Text, View, Image, StatusBar } from 'react-native'
import { Header } from './src/components/Header'
import Profile  from './src/Profile'
import Registration from './src/Registration'
import CurrentEvent from './src/CurrentEvent'
import SignIn from './src/SignIn';
import { Router, Scene, Stack } from 'react-native-router-flux'
import SignUp from './src/SignUp'
import { createAppContainer } from "react-navigation";
import { createStackNavigator } from "react-navigation-stack";

import ChatScreen from "./src/ChatScreen";
import LoginScreen from "./src/LoginScreen";
const AppNavigator = createStackNavigator(
    {
      Login: LoginScreen,
      Chat: ChatScreen
    },
    {
      headerMode: "none"
    }
);
export default createAppContainer(AppNavigator);

