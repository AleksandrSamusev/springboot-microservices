import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';

class EmployeeComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            employee: {},
            department: {},
            organisation: {}
        }

    }

    componentDidMount() {
        EmployeeService.getEmployee().then((response) => {
            this.setState({ employee: response.data.employee })
            this.setState({ department: response.data.department })
            this.setState({ organisation: response.data.organisation })

            console.log(this.state.employee)
            console.log(this.state.department)
            console.log(this.state.organisation)
        })
    }


    render() {
        return (
            <div><br /><br />
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'>View employee details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Employee first name: </strong>{this.state.employee.firstName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee last name: </strong>{this.state.employee.lastName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee email: </strong>{this.state.employee.email}</p>
                        </div>
                    </div>


                    <h3 className='text-center card-header'>View department details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Department name: </strong>{this.state.department.departmentName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department description: </strong>{this.state.department.departmentDescription}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department code: </strong>{this.state.department.departmentCode}</p>
                        </div>
                    </div>


                    <h3 className='text-center card-header'>View organisation details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Organisation name: </strong>{this.state.organisation.organisationName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Organisation description: </strong>{this.state.organisation.organisationDescription}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Organisation code: </strong>{this.state.organisation.organisationCode}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Organisation creation date: </strong>{this.state.organisation.organisationCreatedDate}</p>
                        </div>
                    </div>
                </div>

            </div>
        );
    }
}

export default EmployeeComponent;