import React, { Component } from 'react';
import { Text, Alert, Button, View, StyleSheet, TextInput, TouchableOpacity, TouchableHighlight } from 'react-native';
import { Actions } from 'react-native-router-flux';
import Form from './components/Form';

export default class SignIn extends Component{

    constructor(props)
    {
        super(props);

        this.state = {
            username: '',
            password: '',
        }
    }

    onLogin() {
        Alert.alert('Credentials', `${this.state.username} ${this.state.password}`);
        Actions.toProfile({ name : 'Ivan Ivanov', city:'Tymen', age:'17', rate:'4730'});
    }

    onSignUp(){
        Actions.signUp();
    }

    onForgotPassword(){
        Alert.alert('Gotta remember your password');
    }
    onChanged(item){
        this.setState(item); 
    }

    render(){
        return (
            <View style={styles.container}>
                <View>
                    <Text style={styles.headerText}>Sign In</Text>                   
                        <Form onInputChanged={this.onChanged.bind(this)}/>
                    <TouchableOpacity onPress={this.onForgotPassword.bind(this)}>
                        <Text style={{color: 'blue'}}>Forgot your password?</Text>
                    </TouchableOpacity>
                </View>
                
                <View style={styles.submitContainer}>
                    <TouchableOpacity style={styles.signInButton}             
                      onPress={this.onLogin.bind(this)}
                    >
                        <Text style={styles.buttonContent}>Sign In</Text>
                    </TouchableOpacity>
                    <View style={styles.noAccount}>
                        <Text>Don't have an account? </Text>
                        
                        <TouchableOpacity onPress={this.onSignUp.bind(this)}>
                            <Text style={{color: 'blue'}}>Sign up</Text>
                        </TouchableOpacity>
                    </View>
                </View>
            </View>
          );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        width: '100%',
        justifyContent: 'space-between',
        paddingLeft: 20,
        paddingRight: 20,

    },
    headerText: {
        paddingTop: 10,
        paddingBottom: 10,
        fontWeight: '500',
        fontFamily: 'Roboto',
        marginBottom: 10,
        fontSize: 32
    },
    inputHeader: {
        paddingBottom: 5,
        fontFamily: 'Roboto',
        marginTop: 10,
        fontSize: 14,
        color: '#57586E'
    },
    input: {
        //width: 200,
        //padding: 10,
        borderBottomColor: '#57586E',
        borderBottomWidth: 1,

        marginBottom: 10,
    },
    submitContainer: {
        //width: 200,
        
        //padding: 10,
        marginBottom: 20,
        
    },
    signInButton: {
        flexDirection: 'row',
        alignItems: 'center',
        backgroundColor: '#4BA8EE', 
        height: 50,
        alignContent: 'center',
        justifyContent: 'center'      
    },
    buttonContent: {
        fontFamily: 'Roboto',
        fontSize: 16,
        color: 'white'
    },
    noAccount: {
        marginTop: 20,
        marginBottom: 15,
        alignItems: 'center',
        justifyContent: 'center',
        //flex: 1,
        flexDirection: "row"
    },
  });