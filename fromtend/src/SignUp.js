import React, { Component } from 'react';
import { Text, Alert, Button, View, StyleSheet, TextInput, TouchableOpacity, TouchableHighlight } from 'react-native';
import { Actions } from 'react-native-router-flux';
import Form from './components/Form';

export default class SignUp extends Component{

    constructor(props)
    {
        super(props);

        this.state = {
            username: '',
            password: '',
        }
    }

    onRegister() {
        const { username, password } = this.state;
    
        Alert.alert('Credentials', `${username} + ${password}`);
    }

    onSignIn(){
        Actions.signIn();
    }
    onChanged(item){
        this.setState(item); 
    }

    render(){
        return (
            <View style={styles.container}>
                <View>
                    <Text style={styles.headerText}>Sign Up</Text>
                    <Form onInputChanged={this.onChanged.bind(this)}/>
                </View>
                
                <View style={styles.submitContainer}>
                    <TouchableOpacity style={styles.signInButton}             
                      onPress={this.onRegister.bind(this)}
                    >
                        <Text style={styles.buttonContent}>Sign Up</Text>
                    </TouchableOpacity>
                    <View style={styles.noAccount}>
                        <Text>Don't have an account? </Text>
                        
                        <TouchableOpacity onPress={this.onSignIn.bind(this)}>
                            <Text style={{color: 'blue'}}>Sign In</Text>
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