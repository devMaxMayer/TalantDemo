import React from 'react'
import { StyleSheet, Text, View, Image, StatusBar } from 'react-native'
import { Header } from './src/components/Header'
import Profile  from './src/Profile'
import Registration from './src/Registration'
import CurrentEvent from './src/CurrentEvent'
import SignIn from './src/SignIn';
import { Router, Scene, Stack } from 'react-native-router-flux'
import SignUp from './src/SignUp'
import ChatScreen from './src/ChatScreen'
export default function App() {
    return (
        <View style={styles.container}>


            {/* Страница текущего эвента
         <CurrentEvent name={'505 Fest'} date={'24 Dec 2020'} time={'15:30'}
                    type={'offline'} city={'Tumen'} place={'Tumen TechPark'}/>
     */}

            {/* Страница выбора авторизации

     */}
            <Router>

                <Stack key="root">
                    <Scene key="registration" component={Registration} title="Registration"/>
                    <Scene key="signIn" component={SignIn} title="Sign In"/>
                    <Scene key="signUp" component={SignUp} title="Sign Up"/>
                    <Scene key="toProfile" component={Profile}   title="Profile"/>
                    <Scene key="toEvent" component={CurrentEvent}  />
                    <Scene key="toChat" component={ChatScreen}/>
                </Stack>
            </Router>

            {/* <StatusBar barStyle="light-content" />
        <SignIn/> */}
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: '#ffffff',
        flex: 1,
    }
})